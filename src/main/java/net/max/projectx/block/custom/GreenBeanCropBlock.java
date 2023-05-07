package net.max.projectx.block.custom;

import net.max.projectx.block.ModBlocks;
import net.max.projectx.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.RandomSplitter;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import net.minecraft.util.math.random.Random;

public class GreenBeanCropBlock extends CropBlock {
    public static final IntProperty AGE;
    public static final int MAX_AGE = 13;
    protected static final VoxelShape[] AGE_TO_SHAPE;
    public GreenBeanCropBlock(AbstractBlock.Settings settings) { super(settings); }

    private void placeTopPart(World world, BlockPos pos) {
        BlockPos topPartPos = pos.up();
        world.setBlockState(topPartPos, ModBlocks.GREENBEAN_CROP_TOP.getDefaultState(), Block.NOTIFY_LISTENERS);
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);
        if (age < MAX_AGE && age != 10) { // Prevent growth at stage 10
            super.randomTick(state, world, pos, random);
        }
    }



    @Override
    public int getMaxAge() { return MAX_AGE; };

    @Override
    public IntProperty getAgeProperty() { return AGE; }

    @Override
    protected void appendProperties(@NotNull StateManager.Builder<Block, BlockState> builder) {builder.add(AGE); }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GREENBEAN_SEED;
    }

    @Override
    public VoxelShape getOutlineShape(@NotNull BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        int harvestStage = 10;

        if (age == harvestStage || age == MAX_AGE) {
            if (!world.isClient) {
                // Generate a random number between 1 and 3 (inclusive)
                Random random = new Random() {
                    @Override
                    public Random split() {
                        return null;
                    }

                    @Override
                    public RandomSplitter nextSplitter() {
                        return null;
                    }

                    @Override
                    public void setSeed(long seed) {

                    }

                    @Override
                    public int nextInt() {
                        return 0;
                    }

                    @Override
                    public int nextInt(int bound) {
                        return 0;
                    }

                    @Override
                    public long nextLong() {
                        return 0;
                    }

                    @Override
                    public boolean nextBoolean() {
                        return false;
                    }

                    @Override
                    public float nextFloat() {
                        return 0;
                    }

                    @Override
                    public double nextDouble() {
                        return 0;
                    }

                    @Override
                    public double nextGaussian() {
                        return 0;
                    }
                };
                int dropCount = random.nextInt(3) + 1;

                // Drop your desired item with the random drop count
                dropStack(world, pos, new ItemStack(ModItems.GREENBEAN, dropCount));

                // Revert the crop to two stages before the current age only if it's at the maximum age
                if (age == MAX_AGE) {
                    world.setBlockState(pos, state.with(AGE, age - 2), Block.NOTIFY_LISTENERS);
                } else if (age == harvestStage) {
                    world.setBlockState(pos, state.with(AGE, 11), Block.NOTIFY_LISTENERS);
                }

                world.playSound(null, pos, SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }



    static {
        AGE = IntProperty.of("age", 0, 13);
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
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};
    }
}