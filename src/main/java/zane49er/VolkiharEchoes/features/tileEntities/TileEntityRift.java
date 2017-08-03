package zane49er.VolkiharEchoes.features.tileEntities;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRift extends TileEntity{
	
	Random random = new Random();
	
	public int r = random.nextInt(255);
	public int g = random.nextInt(255);
	public int b = random.nextInt(255);
	
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
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
	}
	
}
