package tv;

public class Tv {
	
	private int channel; // 1 ~ 10
	private int volume; // 1 ~ 255
	private boolean power;
	
	public Tv(int channel,int volume, boolean power) {
		int roundedVolume = roundedVolume(volume);
		int roundedChannel = roundedChannel(channel);
		
		this.channel = roundedChannel;
		this.volume = roundedVolume;
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
	
	public void power(boolean power) {
		this.power = power;
	}
	
	public void channel(int channel) {
		this.channel = roundedChannel(channel);
	}
	
	public void volume(int volume) {
		this.volume = roundedVolume(volume);
	}
	
	public void channel(boolean up) {
		int targetChannel = channel;
		
		if(up) targetChannel +=1;
		else targetChannel -= 1;
		
		channel(targetChannel);
		
	}
	
	public void volume(boolean up) {
		int targetVolume = volume;
		
		if(up) targetVolume +=1;
		else targetVolume -= 1;
		
		volume(targetVolume);
	}
	
	private int roundedVolume(int volume) {
		if (volume <= 0 ) return 255;
		else if (volume > 255) return 1;
		else return volume;
	}
	
	private int roundedChannel(int channel) {
		if (channel <= 0 ) return 10;
		else if (channel > 10) return 1;
		else return channel;
	}
	
	void status() {
		System.out.println("채널:" + channel +" " + "볼륨:" + volume +" " + "파워:"+power); 
	}
	
	
	
	
	
}
