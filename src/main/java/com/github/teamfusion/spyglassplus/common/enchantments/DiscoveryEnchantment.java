package com.github.teamfusion.spyglassplus.common.enchantments;

public class DiscoveryEnchantment extends SPEnchantment {

    public DiscoveryEnchantment() {
        super(Rarity.UNCOMMON);
    }

    @Override
    public int getMinPower(int level) {
        return level * 25;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}
