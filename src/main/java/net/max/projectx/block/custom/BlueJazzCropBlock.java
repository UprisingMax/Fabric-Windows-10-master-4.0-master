package net.max.projectx.block.custom;

import net.max.projectx.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class BlueJazzCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age", 0, 5);

    public BlueJazzCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.BLUE_JAZZ_SEED;
    }

    @Override
    public int getMaxAge() {
        return 5;
    }
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}