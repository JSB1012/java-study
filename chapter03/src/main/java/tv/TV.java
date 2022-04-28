package tv;

public class TV {
	private int channel; // 0 ~ 255 rotation
	private int volume; // 0 ~ 100 rotation
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
//		if (!(volume < 1 || volume > 100)) {
//			volume += (volume + (up ? 1 : -1));
//		}
	}

	public void volume(int volume) {
		if (!power) {
			return;
		}

		if (volume < 0) {
			volume = 100;
		} else if (volume > 100) {
			volume = 0;
		}

		this.volume = volume;
	}

	public void channel(int channel) {
		if (!power) {
			return;
		}

//		if (!(channel < 1 || channel > 255)) {
//			this.channel = channel;
//		}
		if (channel < 0) {
			channel = 255;
		} else if (channel > 255) {
			channel = 0;
		}

		this.channel = channel;
	}

	public void channel(boolean up) {
		// channel(channel + (up ? 1 : -1));
		if (up) {
			channel(channel + 1);
		} else {
			channel(channel - 1);
		}

	}

	public void power(boolean on) {
		this.power = on;
	}

	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power=" + (power ? "on]" : "off]"));
	}

}
