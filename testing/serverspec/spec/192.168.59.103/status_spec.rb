require "spec_helper"
require "serverspec"

set :backend, :exec

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
