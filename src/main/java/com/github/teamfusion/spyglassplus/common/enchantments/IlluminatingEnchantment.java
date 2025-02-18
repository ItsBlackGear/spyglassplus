package com.github.teamfusion.spyglassplus.common.enchantments;

public class IlluminatingEnchantment extends SPEnchantment {

    public IlluminatingEnchantment() {
        super(Rarity.UNCOMMON);
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
}
