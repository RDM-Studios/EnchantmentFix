package com.rdm.enchantmentfix.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;

@Mixin(ProtectionEnchantment.class)
public abstract class ProtectionEnchantmentMixin extends Enchantment {

	public ProtectionEnchantmentMixin(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
		super(weight, target, slotTypes);
	}
	
	@Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
	private void ef$canAccept(Enchantment otherEnchantment, CallbackInfoReturnable<Boolean> info) {
		if (this != otherEnchantment) info.setReturnValue(true);
	}
}