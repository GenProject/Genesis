package genesis.item;

import java.util.List;

import genesis.combo.ToolItems;
import genesis.combo.ToolItems.ToolObjectType;
import genesis.combo.VariantsOfTypesCombo.ItemVariantCount;
import genesis.combo.variant.ToolTypes.ToolType;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;

@ItemVariantCount(1)
public class ItemGenesisSpear extends ItemSword
{
	public final ToolItems owner;
	
	protected final ToolType type;
	protected final ToolObjectType<Block, ItemGenesisSpear> objType;
	
	public ItemGenesisSpear(ToolItems owner, ToolObjectType<Block, ItemGenesisSpear> objType, ToolType type, Class<ToolType> variantClass)
	{
		super(type.toolMaterial);
		
		this.owner = owner;
		this.type = type;
		this.objType = objType;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return owner.getUnlocalizedName(stack, super.getUnlocalizedName(stack));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		super.addInformation(stack, playerIn, tooltip, advanced);
		owner.addToolInformation(stack, playerIn, tooltip, advanced);
	}
}