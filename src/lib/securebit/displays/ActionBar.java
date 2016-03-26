package lib.securebit.displays;

import org.bukkit.entity.Player;

import lib.securebit.ReflectionUtil;

public class ActionBar extends Sendable {
	
	private String bar;
	
	public ActionBar(String bar) {
		this.bar = bar;
	}
	
	public void setBar(String bar) {
		this.bar = bar;
	}
	
	public String getBar() {
		return this.bar;
	}
	
	@Override
	public void send(Player player) {
		super.sendPacket(player, ActionBar.createPacket(this.bar));
	}
	
	public static Object createPacket(String bar) {
		Object text = ReflectionUtil.createStaticObject(DisplayReflection.METHOD_A, "{\"text\": \"" + bar + "\"}");
		
		return ReflectionUtil.createObject(DisplayReflection.CONSTRUCTOR_PACKET_CHAT, text, (byte) 2);
	}
	
}
