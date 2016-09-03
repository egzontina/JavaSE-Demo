package Enum;

import java.util.EnumSet;

import Enum.Example.Group;

public class ExampleMain {

	public static void main(String[] args) {
		
		System.out.println("Example.ENUM_A1.isInGroup(Group.A) : "+ Example.ENUM_A1.isInGroup(Group.A));  // true
		System.out.println("Example.ENUM_A1.isInGroup(Group.B) : "+ Example.ENUM_A1.isInGroup(Group.B));  // false
		
		Example[] t= Example.values();
		System.out.println("Example :" + t.toString());
		
		EnumSet<Example> exampleSetEnum = EnumSet.of(Example.ENUM_A1,Example.ENUM_A2,Example.ENUM_A3 );
		EnumSet<Example> exampleSetEnumAll = EnumSet.allOf(Example.class);
			System.out.println("exampleSetEnum :" + exampleSetEnum.toString() );
			System.out.println("exampleSetEnumAll :" + exampleSetEnumAll.toString() );
	}

}
