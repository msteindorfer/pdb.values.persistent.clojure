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

import com.github.krukow.clj_lang.IFn;
import com.github.krukow.clj_lang.IPersistentCollection;
import com.github.krukow.clj_lang.IPersistentMap;
import com.github.krukow.clj_lang.IPersistentSet;
import com.github.krukow.clj_lang.IPersistentVector;
import com.github.krukow.clj_lang.ISeq;

//import clojure.*;
//import clojure.lang.IFn;
//import clojure.lang.IPersistentCollection;
//import clojure.lang.IPersistentMap;
//import clojure.lang.IPersistentSet;
//import clojure.lang.IPersistentVector;
//import clojure.lang.ISeq;

class ClojureHelper {

	public final static IFn core$cons = null; // new core$cons();	
	public final static ISeq core$cons(Object x, IPersistentCollection xs) {
		return (ISeq) core$cons.invoke(x, xs);
	}
	
	public final static IFn core$next = null; // new core$next();
	public final static ISeq core$next(IPersistentCollection xs) {
		return (ISeq) core$next.invoke(xs);
	}

	public final static IFn core$vec = null; // new core$vec();
	public final static IPersistentVector core$vec(IPersistentCollection xs) {
		return (IPersistentVector) core$vec.invoke(xs);
	}	
	
	public final static IFn core$nthnext = null; // new core$nthnext();
	public final static ISeq core$nthnext(IPersistentCollection xs, int n) {
		return (ISeq) core$nthnext.invoke(xs, n);
	}
	
	public final static IFn core$rest = null; // new core$rest();
	public final static ISeq core$rest(IPersistentCollection xs) {
		return (ISeq) core$rest.invoke(xs);
	}
	
	public final static IFn core$conj = null; // new core$conj();	
	public final static IPersistentCollection core$conj(IPersistentCollection xs, Object x) {
		return (IPersistentCollection) core$conj.invoke(xs, x);
	}	
	
	public final static IFn core$reverse = null; // new core$reverse();
	public final static ISeq core$reverse(IPersistentCollection xs) {
		return (ISeq) core$reverse.invoke(xs);
	}	
	
	public final static IFn core$some = null; // new core$some();
	public final static Object core$some(IFn pred, IPersistentCollection xs) {
		return core$some.invoke(pred, xs);
	}	
	
	public final static IFn core$splitAt = null; // new core$split_at();
	public final static IPersistentVector core$splitAt(int n, IPersistentCollection xs) {
		return (IPersistentVector) core$splitAt.invoke(n, xs);
	}
	
	public final static IFn core$drop = null; // new core$drop();
	public final static ISeq core$drop(int n, IPersistentCollection xs) {
		return (ISeq) core$drop.invoke(n, xs);
	}
	
	public final static IFn core$take = null; // new core$take();
	public final static ISeq core$take(int n, IPersistentCollection xs) {
		return (ISeq) core$take.invoke(n, xs);
	}

	public final static IFn core$concat = null; // new core$concat();
	public final static ISeq core$concat(IPersistentCollection xs, IPersistentCollection ys) {
		return (ISeq) core$concat.invoke(xs, ys);
	}	
		
	public final static IFn set$union = null; // new set$union();
	public final static IPersistentSet set$union(IPersistentSet xs, IPersistentSet ys) {
		return (IPersistentSet) set$union.invoke(xs, ys);
	}
	
	public final static IFn set$intersection = null; // new set$intersection();
	public final static IPersistentSet set$intersection(IPersistentSet xs, IPersistentSet ys) {
		return (IPersistentSet) set$intersection.invoke(xs, ys);
	}

	public final static IFn set$difference = null; // new set$difference();
	public final static IPersistentSet set$difference(IPersistentSet xs, IPersistentSet ys) {
		return (IPersistentSet) set$difference.invoke(xs, ys);
	}
	
	public final static IFn set$isSubset = null; // new set$subset_QMARK_();
	public final static Boolean set$isSubset(IPersistentSet xs, IPersistentSet ys) {
		return (Boolean) set$isSubset.invoke(xs, ys);
	}
	
	public final static IFn core$merge = null; // new core$merge();	
	public final static IPersistentMap core$merge(IPersistentMap xs, IPersistentMap ys) {
		return (IPersistentMap) core$merge.invoke(xs, ys);
	}
	
	public final static IFn core$vals = null; // new core$vals();	
	public final static ISeq core$vals(IPersistentMap xs) {
		return (ISeq) core$vals.invoke(xs);
	}	

	public final static IFn core$keys = null; // new core$keys();	
	public final static ISeq core$keys(IPersistentMap xs) {
		return (ISeq) core$keys.invoke(xs);
	}
	
}
