package openperipheral.adapter.peripheral;

import openperipheral.adapter.IMethodExecutor;
import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.peripheral.IComputerAccess;

public interface IPeripheralMethodExecutor extends IMethodExecutor {
	public Object[] execute(IComputerAccess computer, ILuaContext context, Object target, Object[] args) throws Exception;
}