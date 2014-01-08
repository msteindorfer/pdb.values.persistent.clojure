/*******************************************************************************
* Copyright (c) 2009 Centrum Wiskunde en Informatica (CWI)
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Arnold Lankamp - interfaces and implementation
*******************************************************************************/
package org.eclipse.imp.pdb.facts.impl.persistent.clojure;

import java.util.Iterator;

import org.eclipse.imp.pdb.facts.IList;
import org.eclipse.imp.pdb.facts.IListWriter;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.impl.util.collections.ShareableValuesList;
import org.eclipse.imp.pdb.facts.type.Type;
import org.eclipse.imp.pdb.facts.type.TypeFactory;

import com.github.krukow.clj_lang.IPersistentVector;
import com.github.krukow.clj_lang.ITransientCollection;
import com.github.krukow.clj_lang.PersistentVector;

//import clojure.lang.IPersistentVector;
//import clojure.lang.ITransientCollection;
//import clojure.lang.PersistentVector;

// TODO Add checking.
/**
 * Implementation of IListWriter.
 * 
 * @author Arnold Lankamp
 */
/*package*/ class FastListWriter implements IListWriter{
	protected Type elementType;
	protected final boolean inferred;
	
	protected final ShareableValuesList data;
	
	protected IList constructedList;
	
	/*package*/ FastListWriter(Type elementType){
		super();
		
		this.elementType = elementType;
		this.inferred = false;
		
		data = new ShareableValuesList();
		
		constructedList = null;
	}
	
	/*package*/ FastListWriter(){
		super();
		
		this.elementType = TypeFactory.getInstance().voidType();
		this.inferred = true;
		data = new ShareableValuesList();
		
		constructedList = null;
	}
	
	/*package*/ FastListWriter(Type elementType, ShareableValuesList data){
		super();
		
		this.elementType = elementType;
		this.inferred = false;
		this.data = data;
		
		constructedList = null;
	}
	
	public void append(IValue element){
		checkMutation();
		
		updateType(element);
		data.append(element);
	}
	
	private void updateType(IValue element) {
		if (inferred) {
			elementType = elementType.lub(element.getType());
		}
	}

	public void append(IValue... elems){
		checkMutation();
		
		for(IValue elem : elems){
			updateType(elem);
			data.append(elem);
		}
	}
	
	public void appendAll(Iterable<? extends IValue> collection){
		checkMutation();
		
		Iterator<? extends IValue> collectionIterator = collection.iterator();
		while(collectionIterator.hasNext()){
			IValue next = collectionIterator.next();
			updateType(next);
			data.append(next);
		}
	}
	
	public void insert(IValue elem){
		checkMutation();
		updateType(elem);
		data.insert(elem);
	}
	
	public void insert(IValue... elements){
		insert(elements, 0, elements.length);
	}
	
	public void insert(IValue[] elements, int start, int length){
		checkMutation();
		checkBounds(elements, start, length);
		
		for(int i = start + length - 1; i >= start; i--){
			updateType(elements[i]);
			data.insert(elements[i]);
		}
	}
	
	public void insertAll(Iterable<? extends IValue> collection){
		checkMutation();
		
		Iterator<? extends IValue> collectionIterator = collection.iterator();
		while(collectionIterator.hasNext()){
			IValue next = collectionIterator.next();
			updateType(next);
			data.insert(next);
		}
	}
	
	public void insertAt(int index, IValue element){
		checkMutation();
		
		updateType(element);
		data.insertAt(index, element);
	}
	
	public void insertAt(int index, IValue... elements){
		insertAt(index, elements, 0, 0);
	}
	
	public void insertAt(int index, IValue[] elements, int start, int length){
		checkMutation();
		checkBounds(elements, start, length);
		
		for(int i = start + length - 1; i >= start; i--){
			updateType(elements[i]);
			data.insertAt(index, elements[i]);
		}
	}
	
	public void replaceAt(int index, IValue element){
		checkMutation();
		
		updateType(element);
		data.set(index, element);
	}
	
	public void delete(int index){
		checkMutation();
		
		data.remove(index);
	}
	
	public void delete(IValue element){
		checkMutation();
		
		data.remove(element);
	}
	
	protected void checkMutation(){
		if(constructedList != null) throw new UnsupportedOperationException("Mutation of a finalized list is not supported.");
	}
	
	private void checkBounds(IValue[] elems, int start, int length){
		if(start < 0) throw new ArrayIndexOutOfBoundsException("start < 0");
		if((start + length) > elems.length) throw new ArrayIndexOutOfBoundsException("(start + length) > elems.length");
	}
	
	public int size(){
		return data.size();
	}
	
	public IList  done(){
		if (constructedList == null) {
			ITransientCollection ret = PersistentVector.EMPTY.asTransient();
			for(Object item : data)
				ret = ret.conj(item);
			
			IPersistentVector persistentData = (IPersistentVector) ret.persistent();

			constructedList = new Vector(elementType, persistentData);
		}
		
		return constructedList;
	}
}