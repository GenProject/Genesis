package genesis.metadata;

import java.util.*;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import genesis.block.*;
import genesis.common.*;
import genesis.item.*;
import genesis.util.Constants.Unlocalized;
import genesis.util.FuelHandler;
import genesis.util.ReflectionUtils;

public class DungBlocksAndItems extends VariantsOfTypesCombo<EnumDung>
{
	private static final Class<BlockGenesisVariants<EnumDung>> DUNG_CLASS = ReflectionUtils.convertClass(BlockGenesisVariants.class);
	
	public static final ObjectType<BlockGenesisVariants<EnumDung>, ItemBlockMulti<EnumDung>> DUNG_BLOCK =
			new ObjectType<BlockGenesisVariants<EnumDung>, ItemBlockMulti<EnumDung>>("dung_block", "dung", DUNG_CLASS, null)
			{
				@Override
				public <V extends IMetadata<V>> void afterConstructed(BlockGenesisVariants<EnumDung> block, ItemBlockMulti<EnumDung> item, List<V> variants)
				{
					super.afterConstructed(block, item, variants);
					
					block.setHardness(0.5F);
					block.setStepSound(GenesisSounds.DUNG);
					
					block.clearDrops();
					block.addDrop(DUNG, 4, 4);
					
					Blocks.fire.setFireInfo(block, 5, 5);
					
					FuelHandler.setBurnTime(item,
							TileEntityFurnace.getItemBurnTime(new ItemStack(Blocks.log)) * 4, true);
				}
			}.setUseSeparateVariantJsons(false).setBlockArguments(Material.ground);
	public static final ObjectType<Block, ItemDung> DUNG = new ObjectType<Block, ItemDung>("dung", Unlocalized.Section.MATERIAL + "dung", null, ItemDung.class)
			{
				@Override
				public <V extends IMetadata<V>> void afterConstructed(Block block, ItemDung item, List<V> variants)
				{
					super.afterConstructed(block, item, variants);
					FuelHandler.setBurnTime(item, TileEntityFurnace.getItemBurnTime(new ItemStack(Blocks.log)), true);
				}
			}
			.setCreativeTab(GenesisCreativeTabs.MATERIALS);
	
	public DungBlocksAndItems()
	{
		super(ImmutableList.of(DUNG_BLOCK, DUNG), EnumDung.class, ImmutableList.copyOf(EnumDung.values()));
		
		setUnlocalizedPrefix(Unlocalized.PREFIX);
	}
}
