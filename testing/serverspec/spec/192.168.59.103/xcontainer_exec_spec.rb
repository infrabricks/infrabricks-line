require "spec_helper"
require "serverspec"

describe "Docker Container" do
  before(:all) do
    image = Docker::Image.build_from_dir('.')

    set :os, family: :debian
    set :backend, :docker
    set :docker_image, image.id
  end

  it "installs the right version of debian" do
    expect(os_version).to include("8 (jessie)")
  end

  def os_version
    command("cat /etc/os-release | grep VERSION= | awk -F= '{ print $2}'| tr -d '\"'").stdout
  end
end
