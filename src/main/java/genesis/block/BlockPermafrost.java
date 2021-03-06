package genesis.block;

import genesis.common.sounds.GenesisSoundTypes;
import net.minecraft.block.material.Material;

public class BlockPermafrost extends BlockGenesis
{
	public BlockPermafrost()
	{
		super(Material.ROCK, GenesisSoundTypes.PERMAFROST);
		
		slipperiness = 0.98F;
		setHardness(0.5F);
		setSoundType(GenesisSoundTypes.PERMAFROST);
		setHarvestLevel("pickaxe", 0);
	}
}
