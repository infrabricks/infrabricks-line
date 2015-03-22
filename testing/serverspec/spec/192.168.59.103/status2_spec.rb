require "spec_helper"
require 'serverspec'

set :backend, :docker
describe "dockerfile built ex-status image with docker_image" do

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
