package com.rdm.enchantmentfix.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.screen.AnvilScreenHandler;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin {

	@ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40, ordinal = 2))
	private int modifyMaxExpCost(int input) {
		return Integer.MAX_VALUE;
	}

/*	@Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;getMaxLevel()I"))
	private int modifyMaxEnchantmentLevel(Enchantment enchantment) {
		return Integer.MAX_VALUE;
	}*/
}
