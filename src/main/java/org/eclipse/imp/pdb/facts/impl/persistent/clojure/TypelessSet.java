/*******************************************************************************
 * Copyright (c) 2012-2013 CWI
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

import static org.eclipse.imp.pdb.facts.impl.persistent.clojure.ClojureHelper.set$difference;
import static org.eclipse.imp.pdb.facts.impl.persistent.clojure.ClojureHelper.set$intersection;
import static org.eclipse.imp.pdb.facts.impl.persistent.clojure.ClojureHelper.set$isSubset;
import static org.eclipse.imp.pdb.facts.impl.persistent.clojure.ClojureHelper.set$union;

import java.util.Iterator;

import org.eclipse.imp.pdb.facts.ISet;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.eclipse.imp.pdb.facts.impl.AbstractSet;
import org.eclipse.imp.pdb.facts.impl.func.SetFunctions;
import org.eclipse.imp.pdb.facts.impl.persistent.TypelessPDBPersistentHashSet;
import org.eclipse.imp.pdb.facts.type.Type;
import org.eclipse.imp.pdb.facts.type.TypeFactory;

import clojure.lang.IPersistentSet;
import clojure.lang.PersistentHashSet;

class TypelessSet extends AbstractSet {

	protected final IPersistentSet xs;	

	protected TypelessSet(IPersistentSet xs) {
		this.xs = xs;
	}
			
	protected TypelessSet() {
		this(PersistentHashSet.EMPTY);
	}

	protected TypelessSet(IValue... values) {
		this(PersistentHashSet.create((Object[])values));
	}
	
	protected static Type lub(IValue... xs) {
		return lub(xs, TypeFactory.getInstance().voidType());
	}

	protected static Type lub(IValue[] xs, Type base) {
		Type result = base;

		for (IValue x : xs) {
			result = result.lub(x.getType());			
		}
		
		return result;
	}

	protected Type lub(IValue x) {
		return getElementType().lub(x.getType());
	}

	protected Type lub(ISet xs) {
		return getElementType().lub(xs.getElementType());
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<IValue> iterator() {
		return ((Iterable<IValue>) xs).iterator();
	}

	@Override
	public Type getElementType() {
		return getType().getElementType();
	}

	@Override
	public Type getType() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return xs.count();
	}

	@Override
	public boolean contains(IValue x) {
		return xs.contains(x);
	}

	@Override
	public ISet insert(IValue x) {
		return new TypelessSet((IPersistentSet) xs.cons(x));
	}

	@Override
	public ISet union(ISet other) {
		TypelessSet that = (TypelessSet) other;
		return new TypelessSet(set$union(this.xs, that.xs));
	}
	
	@Override
	public ISet intersect(ISet other) {
		TypelessSet that = (TypelessSet) other;
		return new TypelessSet(set$intersection(this.xs, that.xs));
	}

	@Override
	public ISet subtract(ISet other) {
		TypelessSet that = (TypelessSet) other;
		return new TypelessSet(set$difference(this.xs, that.xs));
	}

	@Override
	public ISet delete(IValue x) {
		// TODO: lub is broken (does not shrink)
		return new TypelessSet(xs.disjoin(x));
	}

	@Override
	public boolean isSubsetOf(ISet other) {
		TypelessSet that = (TypelessSet) other;
		return set$isSubset(this.xs, that.xs); 
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		
		if (other instanceof TypelessSet) {
			TypelessSet that = (TypelessSet) other;
			
			if (this.size() != that.size())
				return false;

			return xs.equals(that.xs);
		}
		
		return false;
	}
	
	@Override
	public boolean isEqual(IValue other) {
		return SetFunctions.isEqual(getValueFactory(), this, other);
	}
	
//	@Override
//	public boolean equals(Object other) {
//		if (other instanceof Set) {
//			Set that = (Set) other;
//			return this.xs.equals(that.xs);
//		} else {
//			return false;
//		}
//	}
//
//	@Override
//	public boolean isEqual(IValue other) {
//		return this.equals(other);
//	}

	@Override
	public int hashCode() {
		return xs.hashCode();
	}

	@Override
	protected IValueFactory getValueFactory() {
		return ValueFactory.getInstance();
	}	
	
}
