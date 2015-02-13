package genesis.world.gen.feature;

import genesis.block.BlockGenesisOre;
import genesis.block.BlockGenesisRock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMinableGenesis extends WorldGenerator 
{
	private Block ore;
	/**
	 * The number of blocks to generate.
	 */
	private int numberOfBlocks;
	private Block stone;
	private int mineableBlockMeta;
	private boolean singleStone = true;

	public WorldGenMinableGenesis(Block block, int numBlocks) 
	{
		this(block, numBlocks, null);
		singleStone = false;
	}

	public WorldGenMinableGenesis(Block block, int numBlocks, Block stone) 
	{
		this.ore = block;
		this.numberOfBlocks = numBlocks;
		this.stone = stone;
	}

	public WorldGenMinableGenesis(Block block, int meta, int number, Block target) 
	{
		this(block, number, target);
		this.mineableBlockMeta = meta;
	}

	public boolean generate(World world, Random random, BlockPos pos) 
	{
		float f = random.nextFloat() * (float) Math.PI;
		double d0 = (double) ((float) (pos.getX() + 8) + MathHelper.sin(f) * (float) this.numberOfBlocks / 8.0F);
		double d1 = (double) ((float) (pos.getX() + 8) - MathHelper.sin(f) * (float) this.numberOfBlocks / 8.0F);
		double d2 = (double) ((float) (pos.getZ() + 8) + MathHelper.cos(f) * (float) this.numberOfBlocks / 8.0F);
		double d3 = (double) ((float) (pos.getZ() + 8) - MathHelper.cos(f) * (float) this.numberOfBlocks / 8.0F);
		double d4 = (double) (pos.getY() + random.nextInt(3) - 2);
		double d5 = (double) (pos.getY() + random.nextInt(3) - 2);

		for (int l = 0; l <= this.numberOfBlocks; ++l) 
		{
			double d6 = d0 + (d1 - d0) * (double) l / (double) this.numberOfBlocks;
			double d7 = d4 + (d5 - d4) * (double) l / (double) this.numberOfBlocks;
			double d8 = d2 + (d3 - d2) * (double) l / (double) this.numberOfBlocks;
			double d9 = random.nextDouble() * (double) this.numberOfBlocks / 16.0D;
			double d10 = (double) (MathHelper.sin((float) l * (float) Math.PI / (float) this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
			double d11 = (double) (MathHelper.sin((float) l * (float) Math.PI / (float) this.numberOfBlocks) + 1.0F) * d9 + 1.0D;
			int i1 = MathHelper.floor_double(d6 - d10 / 2.0D);
			int j1 = MathHelper.floor_double(d7 - d11 / 2.0D);
			int k1 = MathHelper.floor_double(d8 - d10 / 2.0D);
			int l1 = MathHelper.floor_double(d6 + d10 / 2.0D);
			int i2 = MathHelper.floor_double(d7 + d11 / 2.0D);
			int j2 = MathHelper.floor_double(d8 + d10 / 2.0D);

			for (int k2 = i1; k2 <= l1; ++k2) 
			{
				double d12 = ((double) k2 + 0.5D - d6) / (d10 / 2.0D);

				if (d12 * d12 < 1.0D) 
				{
					for (int l2 = j1; l2 <= i2; ++l2) 
					{
						double d13 = ((double) l2 + 0.5D - d7) / (d11 / 2.0D);

						if (d12 * d12 + d13 * d13 < 1.0D) 
						{
							for (int i3 = k1; i3 <= j2; ++i3) 
							{
								double d14 = ((double) i3 + 0.5D - d8) / (d10 / 2.0D);

								if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D)
								{
									BlockPos thisPos = new BlockPos(k2, l2, i3);
									if (singleStone) 
									{
										if (world.getBlockState(thisPos).getBlock() == stone) 
										{
											//TODO: Get the ore stuff working.
											//par1World.setBlockState(thisPos, this.ore, mineableBlockMeta, 2);
										}
									} 
									else if (world.getBlockState(thisPos) instanceof BlockGenesisRock) 
									{
										//par1World.setBlockState(thisPos, this.ore, mineableBlockMeta, 2);
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}