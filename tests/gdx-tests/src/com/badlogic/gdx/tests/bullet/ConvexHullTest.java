/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.tests.bullet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.loaders.obj.ObjLoader;
import com.badlogic.gdx.physics.bullet.btConvexHullShape;
import com.badlogic.gdx.physics.bullet.btShapeHull;
import com.badlogic.gdx.tests.bullet.BaseBulletTest.Entity;

/** @author xoppa */
public class ConvexHullTest extends BaseBulletTest {

	@Override
	public void create () {
		super.create();
		
		final Mesh sceneMesh = ObjLoader.loadObj(Gdx.files.internal("data/car.obj").read(), true, true);
		
		world.constructors.put("car", new Entity.ConstructInfo(sceneMesh, 5f, createConvexHullShape(sceneMesh)));

		// Create the entities
		world.add("ground", 0f, 0f, 0f)
			.color.set(0.25f + 0.5f * (float)Math.random(), 0.25f + 0.5f * (float)Math.random(), 0.25f + 0.5f * (float)Math.random(), 1f);
		
		for (float y = 10f; y < 50f; y += 5f)
			world.add("car", -2f+(float)Math.random()*4f, y, -2f+(float)Math.random()*4f)
				.color.set(0.25f + 0.5f * (float)Math.random(), 0.25f + 0.5f * (float)Math.random(), 0.25f + 0.5f * (float)Math.random(), 1f);
	}
	
	@Override
	public boolean tap (float x, float y, int count, int button) {
		shoot(x, y);
		return true;
	}
	
	public static btConvexHullShape createConvexHullShape(final Mesh mesh) {
		final float[] vertices = new float[mesh.getNumVertices()*mesh.getVertexSize()/4];
		mesh.getVertices(vertices);
		final btConvexHullShape shape = new btConvexHullShape(vertices, mesh.getNumVertices(), mesh.getVertexSize());
		// now optimize the shape
		final btShapeHull hull = new btShapeHull(shape);
		hull.buildHull(shape.getMargin());
		final btConvexHullShape result = hull.createConvexHullShape();
		// delete the temporary shape
		shape.delete();
		return result;
	}
}
