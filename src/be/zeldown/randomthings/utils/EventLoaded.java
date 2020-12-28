package be.zeldown.randomthings.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.bukkit.entity.Player;

import lombok.Getter;

public class EventLoaded implements InvocationHandler {

	private String name;
	private String perform;
	
	@Getter private Proxy proxy;
	
	public EventLoaded(String name, String perform) {
		Proxy eventProxy = (Proxy) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] { ARandomEvent.class},
                this);
		
		this.name = name;
		this.perform = perform;
		this.proxy = eventProxy;
		 
	}

	@Override
	public Object invoke(Object aProxy, Method aMethod, Object[] someArguments) {
		if (aMethod.getDeclaringClass() == ARandomEvent.class) {
            if (aMethod.getName().equals("name")) {
                return this.name;
            }else if (aMethod.getName().equals("perform")) {
            	Player p = (Player) someArguments[0];
            	
            	p.sendMessage("§cExternal Scripting not active (yet)");
            }
		}
		return null;
	}
	
}
