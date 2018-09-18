package net.inizicraft.inizibrew;

import org.bukkit.potion.PotionEffectType;

public class Effects {

		static PotionEffectType getEffect(String effect) {
			
			if(effect.equalsIgnoreCase("absorption"))
				return PotionEffectType.ABSORPTION;
			if(effect.equalsIgnoreCase("blindness"))
				return PotionEffectType.BLINDNESS;
			if(effect.equalsIgnoreCase("conduit_power"))
				return PotionEffectType.CONDUIT_POWER;
			if(effect.equalsIgnoreCase("confusion"))
				return PotionEffectType.CONFUSION;
			if(effect.equalsIgnoreCase("damage_resistance"))
				return PotionEffectType.DAMAGE_RESISTANCE;
			if(effect.equalsIgnoreCase("dolphins_grace"))
				return PotionEffectType.DOLPHINS_GRACE;
			if(effect.equalsIgnoreCase("fast_digging"))
				return PotionEffectType.FAST_DIGGING;
			if(effect.equalsIgnoreCase("fire_resistance"))
				return PotionEffectType.FIRE_RESISTANCE;
			if(effect.equalsIgnoreCase("glowing"))
				return PotionEffectType.GLOWING;
			if(effect.equalsIgnoreCase("harm"))
				return PotionEffectType.HARM;
			if(effect.equalsIgnoreCase("heal"))
				return PotionEffectType.HEAL;
			if(effect.equalsIgnoreCase("health_boost"))
				return PotionEffectType.HEALTH_BOOST;
			if(effect.equalsIgnoreCase("hunger"))
				return PotionEffectType.HUNGER;
			if(effect.equalsIgnoreCase("increase_damage"))
				return PotionEffectType.INCREASE_DAMAGE;
			if(effect.equalsIgnoreCase("invisibility"))
				return PotionEffectType.INVISIBILITY;
			if(effect.equalsIgnoreCase("jump"))
				return PotionEffectType.JUMP;
			if(effect.equalsIgnoreCase("levitation"))
				return PotionEffectType.LEVITATION;
			if(effect.equalsIgnoreCase("luck"))
				return PotionEffectType.LUCK;
			if(effect.equalsIgnoreCase("night_vision"))
				return PotionEffectType.NIGHT_VISION;
			if(effect.equalsIgnoreCase("poison"))
				return PotionEffectType.POISON;
			if(effect.equalsIgnoreCase("regeneration"))
				return PotionEffectType.REGENERATION;
			if(effect.equalsIgnoreCase("saturation"))
				return PotionEffectType.SATURATION;
			if(effect.equalsIgnoreCase("slow"))
				return PotionEffectType.SLOW;
			if(effect.equalsIgnoreCase("slow_digging"))
				return PotionEffectType.SLOW_DIGGING;
			if(effect.equalsIgnoreCase("slow_falling"))
				return PotionEffectType.SLOW_FALLING;
			if(effect.equalsIgnoreCase("speed"))
				return PotionEffectType.SPEED;
			if(effect.equalsIgnoreCase("unluck"))
				return PotionEffectType.UNLUCK;
			if(effect.equalsIgnoreCase("water_breathing"))
				return PotionEffectType.WATER_BREATHING;
			if(effect.equalsIgnoreCase("weakness"))
				return PotionEffectType.WEAKNESS;
			if(effect.equalsIgnoreCase("wither"))
				return PotionEffectType.WITHER;
			
			System.out.println("No Potion type was provided");
			return null;
		}
}
