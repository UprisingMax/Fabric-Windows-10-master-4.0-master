package net.max.projectx.block.custom;

import net.max.projectx.block.ModBlocks;
import net.max.projectx.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.math.random.RandomSplitter;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class StrawberryCropBlock extends CropBlock {
    public static final IntProperty AGE;
    public static final int MAX_AGE = 13;
    protected static final VoxelShape[] AGE_TO_SHAPE;
    public StrawberryCropBlock(Settings settings) { super(settings); }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);
        if (age < MAX_AGE && age != 8) { // Prevent growth at stage 9
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
        return ModItems.STRAWBERRY_SEED;
    }

    @Override
    public VoxelShape getOutlineShape(@NotNull BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int age = state.get(AGE);
        int harvestStage = 8;

        if (age == harvestStage || age == MAX_AGE) {
            if (!world.isClient) {
                // Always drop at least one strawberry
                int dropCount = 1;

                // Generate a random number between 1 and 100
                int randomInt = world.random.nextInt(100);

                // If the random number is less than or equal to 2, add between 1 and 3 additional strawberries
                if (randomInt <= 2) {
                    dropCount += world.random.nextInt(3) + 1;
                }

                // Drop the strawberries
                dropStack(world, pos, new ItemStack(ModItems.STRAWBERRY, dropCount));

                // Revert the crop to three stages before the current age only if it's at the maximum age
                if (age == MAX_AGE) {
                    world.setBlockState(pos, state.with(AGE, age - 3), Block.NOTIFY_LISTENERS);
                } else if (age == harvestStage) {
                    world.setBlockState(pos, state.with(AGE, 9), Block.NOTIFY_LISTENERS);
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