package openperipheral.integration.thermalexpansion;

import java.util.Locale;

import openperipheral.api.*;
import cofh.api.tileentity.ISecureTile;
import cofh.api.tileentity.ISecureTile.AccessMode;

public class AdapterSecureTile implements IPeripheralAdapter {

	@Override
	public Class<?> getTargetClass() {
		return ISecureTile.class;
	}

	@LuaMethod(description = "Gets the owner of the machine.", returnType = LuaType.STRING)
	public String getOwnerName(ISecureTile tile) {
		return tile.getOwnerName();
	}

	@LuaMethod(description = "Is this username allowed to access the machine.", returnType = LuaType.BOOLEAN, args = {
			@Arg(name = "username", description = "The username to check for", type = LuaType.STRING)
	})
	public boolean canPlayerAccess(ISecureTile tile, String name) {
		return tile.canPlayerAccess(name);
	}

	@LuaMethod(description = "Gets the AccessMode of this machine.", returnType = LuaType.STRING)
	public String getAccess(ISecureTile tile) {
		return tile.getAccess().name();
	}

	@LuaMethod(description = "Sets the AccessMode of this machine.", returnType = LuaType.BOOLEAN, args = {
			@Arg(name = "accessMode", description = "The access mode you wish to set (can be PUBLIC,RESTRICTED or PRIVATE)", type = LuaType.STRING)
	})
	public boolean setAccess(ISecureTile tile, String access) {
		try {
			AccessMode mode = AccessMode.valueOf(access.toUpperCase(Locale.ENGLISH));
			return tile.setAccess(mode);
		} catch (IllegalArgumentException e) {}
		return false;
	}
}
