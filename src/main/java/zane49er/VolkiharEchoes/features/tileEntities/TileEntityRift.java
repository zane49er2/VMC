package zane49er.VolkiharEchoes.features.tileEntities;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRift extends TileEntity {
	

	public int r;// = random.nextInt(255);
	public int g;// = random.nextInt(255);
	public int b;// = random.nextInt(255);

	@Override
	public void onLoad() {
		if (this.r == 0) {
			Random random = new Random();
			this.r = random.nextInt(255)+1;
			this.g = random.nextInt(255)+1;
			this.b = random.nextInt(255)+1;
		}
		super.onLoad();
	}
	
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
		if (this.r == 0) {
			Random random = new Random();
			this.r = random.nextInt(255)+1;
			this.g = random.nextInt(255)+1;
			this.b = random.nextInt(255)+1;
		}
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		writeToNBT(nbtTagCompound);
		return nbtTagCompound;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

}
