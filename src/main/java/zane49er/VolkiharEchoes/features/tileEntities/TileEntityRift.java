package zane49er.VolkiharEchoes.features.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRift extends TileEntity{
	
	public int r = 255;
	public int g = 0;
	public int b = 0;
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("red", r);
		compound.setInteger("green", g);
		compound.setInteger("blue", b);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.r = compound.getInteger("red");
		this.g = compound.getInteger("green");
		this.b = compound.getInteger("blue");
	}
}
