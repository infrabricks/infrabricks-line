

**set up sample**

```
$ mkdir -p webapps/status
$ cat >webapps/status/index.jsp <<EOF
Hello dockers
EOF
$ cat >Dockerfile <<EOF
FROM infrabricks/tomcat:8
ADD webapps/status /opt/tomcat/webapps/status
EOF
$ docker build -t infrabricks/ex-status .
```

**spec/spec_helper.rb**

```
require "docker"

docker_host = ENV['DOCKER_HOST'].dup

if(ENV['DOCKER_TLS_VERIFY'])
  cert_path = File.expand_path ENV['DOCKER_CERT_PATH']
  Docker.options = {
    client_cert: File.join(cert_path, 'cert.pem'),
    client_key: File.join(cert_path, 'key.pem')
  }
  Excon.defaults[:ssl_ca_file] = File.join(cert_path, 'ca.pem')
  docker_host.gsub!(/^tcp/,'https')
end

Docker.url = docker_host
```

**spec/$(boot2docker ip)/status_spec.rb**


```
require "spec_helper"

describe "dockerfile built ex-status image" do
  before(:all) do
    @image = Docker::Image.all(:all => true).find { |image|
      Docker::Util.parse_repo_tag( image.info['RepoTags'].first ).first == 'infrabricks/ex-status'
    }
    p @image.json["Env"]
  end

  it "should exist" do
    expect(@image).not_to be_nil
  end

  it "should have CMD" do
    expect(@image.json["Config"]["Cmd"]).to include("/opt/tomcat/bin/tomcat.sh")
  end

  it "should expose the default port" do
    expect(@image.json["Config"]["ExposedPorts"].has_key?("8080/tcp")).to be_truthy
  end

end
```

**spec/$(boot2docker ip)/status2_spec.rb**

```
require "spec_helper"
require "server_spec"

set :backend, :docker

describe "dockerfile built ex-status image" do

  describe docker_image('infrabricks/ex-status:latest') do
    it { should exist }
  end

  describe docker_image('infrabricks/ex-status:latest') do
    its(:inspection) { should include 'Architecture' => 'amd64' }
    its(['Architecture']) { should eq 'amd64' }
    its(['Config.Cmd']) { should include '/opt/tomcat/bin/tomcat.sh' }
    its(['Config.ExposedPorts']) { should include '8080/tcp' => {} }
  end
end
```

## Execute tests

```
bundle install --path
bundle exec rake
```

## Link

* http://ian.blenke.com/blog/2014/11/10/docker-rspec-tdd/
* https://github.com/swipely/docker-api
* https://github.com/tcnksm-sample/docker-rspec
* http://blog.wercker.com/2013/12/23/Test-driven-development-for-docker.html
* https://github.com/de-wiring/containerspec
* http://www.infrabricks.de/blog/2014/09/10/docker-container-mit-serverspec-testen/
* https://speakerdeck.com/rossbachp/triple-d-test-driven-docker-development
