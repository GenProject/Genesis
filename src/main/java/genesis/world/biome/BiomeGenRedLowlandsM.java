package genesis.world.biome;

import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import genesis.common.GenesisBlocks;
import genesis.metadata.EnumPlant;
import genesis.metadata.EnumSilt;
import genesis.metadata.PlantBlocks;
import genesis.metadata.SiltBlocks;
import genesis.world.biome.decorate.WorldGenMossStages;
import genesis.world.biome.decorate.WorldGenPlant;
import genesis.world.gen.feature.WorldGenTreeVoltzia;

public class BiomeGenRedLowlandsM extends BiomeGenRedLowlands
{
	public BiomeGenRedLowlandsM(int id)
	{
		super(id);
		setBiomeName("Red Lowlands M");
		setHeight(0.4F, 0.6F);
	}
	
	protected void addDecorations()
	{
		addDecoration(new WorldGenMossStages().addAllowedBlocks(GenesisBlocks.silt.getBlockState(SiltBlocks.SILT, EnumSilt.SILT), GenesisBlocks.silt.getBlockState(SiltBlocks.SILT, EnumSilt.RED_SILT), Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT)).setCountPerChunk(25));
		addDecoration(new WorldGenPlant(GenesisBlocks.plants, PlantBlocks.DOUBLE_PLANT, EnumPlant.AETHOPHYLLUM).setCountPerChunk(1));
		addDecoration(new WorldGenPlant(EnumPlant.APOLDIA).addAllowedBlocks(GenesisBlocks.silt.getBlock(SiltBlocks.SILT, EnumSilt.SILT), GenesisBlocks.silt.getBlock(SiltBlocks.SILT, EnumSilt.RED_SILT)).setCountPerChunk(1));
	}
	
	@Override
	protected void addTrees()
	{
		addTree(new WorldGenTreeVoltzia(5, 10, true).setTreeCountPerChunk(5).setRarity(1));
	}
}
