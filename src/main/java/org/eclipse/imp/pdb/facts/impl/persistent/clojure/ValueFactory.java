/*******************************************************************************
 * Copyright (c) 2012 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *   * Michael Steindorfer - Michael.Steindorfer@cwi.nl - CWI  
 *******************************************************************************/
package org.eclipse.imp.pdb.facts.impl.persistent.clojure;

import java.net.URI;
import java.util.Map;

import org.eclipse.imp.pdb.facts.IBool;
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.IDateTime;
import org.eclipse.imp.pdb.facts.IInteger;
import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IListWriter;
import org.eclipse.imp.pdb.facts.IMap;
import org.eclipse.imp.pdb.facts.IMapWriter;
import org.eclipse.imp.pdb.facts.INode;
import org.eclipse.imp.pdb.facts.IRational;
import org.eclipse.imp.pdb.facts.IReal;
import org.eclipse.imp.pdb.facts.IRelation;
import org.eclipse.imp.pdb.facts.IRelationWriter;
import org.eclipse.imp.pdb.facts.ISet;
import org.eclipse.imp.pdb.facts.ISetWriter;
import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.eclipse.imp.pdb.facts.IString;
import org.eclipse.imp.pdb.facts.ITuple;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.eclipse.imp.pdb.facts.exceptions.FactTypeUseException;
import org.eclipse.imp.pdb.facts.type.Type;

public class ValueFactory implements IValueFactory {

	@Override
	public IInteger integer(String i) throws NumberFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInteger integer(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInteger integer(long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInteger integer(byte[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRational rational(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRational rational(long a, long b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRational rational(IInteger a, IInteger b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRational rational(String rat) throws NumberFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReal real(String s) throws NumberFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReal real(String s, int p) throws NumberFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReal real(double d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReal real(double d, int p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInteger precision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IInteger setPrecision(int p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReal pi(int precision) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IReal e(int precision) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IString string(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IString string(int[] chars) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IString string(int ch) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISourceLocation sourceLocation(URI uri, int offset, int length,
			int beginLine, int endLine, int beginCol, int endCol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISourceLocation sourceLocation(URI uri, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISourceLocation sourceLocation(String path, int offset, int length,
			int beginLine, int endLine, int beginCol, int endCol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISourceLocation sourceLocation(URI uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISourceLocation sourceLocation(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITuple tuple() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITuple tuple(IValue... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode node(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode node(String name, IValue... children) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode node(String name, Map<String, IValue> annotations,
			IValue... children) throws FactTypeUseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IConstructor constructor(Type constructor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IConstructor constructor(Type constructor, IValue... children)
			throws FactTypeUseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IConstructor constructor(Type constructor,
			Map<String, IValue> annotations, IValue... children)
			throws FactTypeUseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISet set(Type eltType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISetWriter setWriter(Type eltType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISetWriter setWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISet set(IValue... elems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IList list(Type eltType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IListWriter listWriter(Type eltType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IListWriter listWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IList list(IValue... elems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRelation relation(Type tupleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRelationWriter relationWriter(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRelationWriter relationWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRelation relation(IValue... elems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMap map(Type key, Type value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMapWriter mapWriter(Type key, Type value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMapWriter mapWriter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBool bool(boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDateTime date(int year, int month, int day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDateTime time(int hour, int minute, int second, int millisecond) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDateTime time(int hour, int minute, int second, int millisecond,
			int hourOffset, int minuteOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDateTime datetime(int year, int month, int day, int hour,
			int minute, int second, int millisecond) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDateTime datetime(int year, int month, int day, int hour,
			int minute, int second, int millisecond, int hourOffset,
			int minuteOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDateTime datetime(long instant) {
		// TODO Auto-generated method stub
		return null;
	}

}
