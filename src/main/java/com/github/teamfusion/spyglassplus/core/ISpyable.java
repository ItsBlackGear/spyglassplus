package com.github.teamfusion.spyglassplus.core;

public interface ISpyable {

	void setCommand(boolean command);

	boolean isCommand();

	void setCommandTick(int tick);

	int getCommandTick();
}
