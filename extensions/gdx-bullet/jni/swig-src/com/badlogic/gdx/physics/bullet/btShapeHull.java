/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.badlogic.gdx.physics.bullet;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;

public class btShapeHull {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected btShapeHull(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(btShapeHull obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gdxBulletJNI.delete_btShapeHull(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public btShapeHull(btConvexShape shape) {
    this(gdxBulletJNI.new_btShapeHull(btConvexShape.getCPtr(shape), shape), true);
  }

  public boolean buildHull(float margin) {
    return gdxBulletJNI.btShapeHull_buildHull(swigCPtr, this, margin);
  }

  public int numTriangles() {
    return gdxBulletJNI.btShapeHull_numTriangles(swigCPtr, this);
  }

  public int numVertices() {
    return gdxBulletJNI.btShapeHull_numVertices(swigCPtr, this);
  }

  public int numIndices() {
    return gdxBulletJNI.btShapeHull_numIndices(swigCPtr, this);
  }

  public btVector3 getVertexPointer() {
    long cPtr = gdxBulletJNI.btShapeHull_getVertexPointer(swigCPtr, this);
    return (cPtr == 0) ? null : new btVector3(cPtr, false);
  }

  public SWIGTYPE_p_unsigned_int getIndexPointer() {
    long cPtr = gdxBulletJNI.btShapeHull_getIndexPointer(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public btConvexHullShape createConvexHullShape() {
    long cPtr = gdxBulletJNI.btShapeHull_createConvexHullShape(swigCPtr, this);
    return (cPtr == 0) ? null : new btConvexHullShape(cPtr, false);
  }

}
