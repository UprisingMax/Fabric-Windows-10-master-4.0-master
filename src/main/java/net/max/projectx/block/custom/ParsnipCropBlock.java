package net.max.projectx.block.custom;

import net.max.projectx.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class ParsnipCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age", 0, 4);

    public ParsnipCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.PARSNIP_SEED;
    }

    @Override
    public int getMaxAge() {
        return 4;
    }
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}