package net.max.projectx.block.custom;

import net.max.projectx.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CoffeeBeanCropBlock extends CropBlock {
    public static final IntProperty AGE;
    public static final int MAX_AGE = 10;
    protected static final VoxelShape[] AGE_TO_SHAPE;
    public CoffeeBeanCropBlock(AbstractBlock.Settings settings) { super(settings); }

    @Override
    public int getMaxAge() { return MAX_AGE; };

    @Override
    public IntProperty getAgeProperty() { return AGE; }

    @Override
    protected void appendProperties(@NotNull StateManager.Builder<Block, BlockState> builder) {builder.add(AGE); }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.COFFEE_BEAN_SEED;
    }

    @Override
    public VoxelShape getOutlineShape(@NotNull BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        if (age == MAX_AGE) {
            if (!world.isClient) {
                // Generate a random number between 1 and 3 (inclusive)
                Random random = new Random();
                int dropCount = random.nextInt(3) + 1;

                // Drop your desired item with the random drop count
                dropStack(world, pos, new ItemStack(ModItems.COFFEE_BEAN_SEED, dropCount));

                // Revert the crop to two stages before the maximum age
                world.setBlockState(pos, state.with(AGE, MAX_AGE - 2), Block.NOTIFY_LISTENERS);
                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }



    static {
        AGE = IntProperty.of("age", 0, 10);
        AGE_TO_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};
    }
}