require "spec_helper"
require "serverspec"

describe "Docker Container with container id" do
  before(:all) do
    image = Docker::Image.build_from_dir('.')
    container = image.run()
    set :os, family: :debian
    set :backend, :docker
    set :docker_container, container.id
  end

  it "installs the right version of debian" do
    expect(os_version).to include("8 (jessie)")
  end

  def os_version
    command("cat /etc/os-release | grep VERSION= | awk -F= '{ print $2}'| tr -d '\"'").stdout
  end
end
