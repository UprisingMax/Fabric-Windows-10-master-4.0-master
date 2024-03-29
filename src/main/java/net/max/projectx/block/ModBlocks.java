package net.max.projectx.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.max.projectx.ProjectX;
import net.max.projectx.block.custom.*;
import net.max.projectx.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block JUMPY_BLOCK = registerBlock("jumpy_block",
            new JumpyBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_LAMP = registerBlock("tanzanite_lamp",
            new TanzaniteLampBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()
                    .luminance(state ->state.get(TanzaniteLampBlock.LIT) ? 15: 0)), ModItemGroup.TANZANITE);

    public static final Block EGGPLANT_CROP = registerBlockWithoutItem("eggplant_crop",
            new EggplantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    public static final Block DEEPSLATE_ADAMANTIUM_ORE = registerBlock("deepslate_adamantium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.PROJECTX);

    public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.PROJECTX);

    public static final Block DEEPSLATE_DEEP_IRON_ORE = registerBlock("deepslate_deep_iron_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.PROJECTX);

    public static final Block END_STONE_INFUSCOLIUM_ORE = registerBlock("end_stone_infuscolium_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE),
                    UniformIntProvider.create(3, 7)), ModItemGroup.PROJECTX);

    public static final Block HELLSTONE_ORE = registerBlock("hellstone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERRACK),
                    UniformIntProvider.create(3, 7)), ModItemGroup.PROJECTX);

    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.PROJECTX);

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.PROJECTX);

    public static final Block DEEP_IRON_BLOCK = registerBlock("deep_iron_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.PROJECTX);

    public static final Block INFUSCOLIUM_BLOCK = registerBlock("infuscolium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.PROJECTX);

    public static final Block HELLSTONE_BLOCK = registerBlock("hellstone_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.PROJECTX);

    public static final Block BLACK_STEEL_BLOCK = registerBlock("black_steel_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.PROJECTX);

    public static final Block BLUE_JAZZ_CROP = registerBlockWithoutItem("blue_jazz_crop",
            new BlueJazzCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutItem("cauliflower_crop",
            new CauliflowerCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block PARSNIP_CROP = registerBlockWithoutItem("parsnip_crop",
            new ParsnipCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block COFFEEBEAN_CROP = registerBlockWithoutItem("coffeebean_crop",
            new CoffeeBeanCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block GARLIC_CROP = registerBlockWithoutItem("garlic_crop",
            new GarlicCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block GREENBEAN_CROP = registerBlockWithoutItem("greenbean_crop",
            new GreenBeanCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block KALE_CROP = registerBlockWithoutItem("kale_crop",
            new KaleCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block POTATO_CROP = registerBlockWithoutItem("potato_crop",
            new PotatoCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block RHUBARB_CROP = registerBlockWithoutItem("rhubarb_crop",
            new RhubarbCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    public static final Block STRAWBERRY_CROP = registerBlockWithoutItem("strawberry_crop",
            new StrawberryCropBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));


    public static final Block GREENBEAN_CROP_TOP = registerBlockWithoutItem("greenbean_crop_top",
            new GreenBeanCropTopBlock(AbstractBlock.Settings.of(Material.PLANT)
                    .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ProjectX.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(ProjectX.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(ProjectX.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));

    }


    public static void registerModBlocks() {
        ProjectX.LOGGER.debug("Registering ModBlocks for " + ProjectX.MOD_ID);
    }
}
