package com.rdm.enchantmentfix.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.text.Text;

@Mixin(AnvilScreen.class)
public abstract class AnvilScreenMixin extends Screen {

	public AnvilScreenMixin(Text title) {
		super(title);
	}

	@ModifyConstant(method = "drawForeground", constant = @Constant(intValue = 40, ordinal = 0))
	private int modifyMaxExpCost(int input) {
		return Integer.MAX_VALUE;
	}
}
