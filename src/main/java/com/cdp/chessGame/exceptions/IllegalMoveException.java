package com.cdp.chessGame.exceptions;

import com.cdp.chessGame.enums.IllegalMoveReason;
import com.cdp.chessGame.interfaces.Move;

public class IllegalMoveException extends Exception 
{
	private Move move;
	private IllegalMoveReason reason;
	
	public IllegalMoveException(Move move, IllegalMoveReason reason)
	{
		this.move = move;
		this.reason = reason;
	}
	
	public Move getMove()
	{
		return move;
	}
	
	public IllegalMoveReason getReason()
	{
		return reason;
	}
}
