package Interfaz;

import java.util.ArrayList;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;

import com.beust.jcommander.internal.Console;

public class Polar {

	int matrizSolucion[][]= new int[4][4];

	/**
	 * COnstructor de la clase POLAR
	 * @param valorxP
	 * @param valoryP
	 * @param valorzP 
	 */
	public Polar(int valorxP, int valoryP, int valorzP){

		/**
		 * Valores predeterminados de matriz solucion
		 */
		matrizSolucion[0][3] = 15;

		matrizSolucion[1][3] = 12;

		matrizSolucion[2][3] = 18;

		matrizSolucion[3][0] = 12;
		matrizSolucion[3][1] = 14;
		matrizSolucion[3][2] = 19;
		matrizSolucion[3][3] = 18;
	}

	/**
	 * Metodo que genera las posibles soluciones a partir de 
	 * las restricciones.
	 */
	public void asignarValores(){
		
		//Modelo para la solución 
		Model modelo= new Model();
		IntVar x=modelo.intVar("",1,9);
		IntVar y=modelo.intVar("",1,9);
		IntVar z=modelo.intVar("",1,9);

		IntVar w=modelo.intVar("",1,9);
		IntVar b=modelo.intVar("",1,9);
		IntVar v=modelo.intVar("",1,9);

		IntVar p=modelo.intVar("",1,9);
		IntVar q=modelo.intVar("",1,9);
		IntVar r=modelo.intVar("",1,9); 

		modelo.allDifferent(new IntVar[]{x,y,z,w,b,v,p,q,r}).post(); 

		x.eq(7).post();
		x.ne(y).post();
		x.ne(z).post();
		z.ne(x).post();
		z.ne(y).post();
		x.add(y).add(z).eq(15).post();

		w.ne(b).post();
		w.ne(v).post();
		w.ne(b).post();
		b.ne(w).post();
		b.ne(v).post();
		v.ne(w).post();
		v.ne(b).post();
		w.add(b).add(v).eq(12).post();

		p.ne(q).post();
		p.ne(r).post();
		q.ne(p).post();
		q.ne(r).post();
		r.ne(p).post();
		r.ne(q).post();
		p.add(q).add(r).eq(18).post();

		x.ne(w).post();
		x.ne(p).post();
		w.ne(x).post();
		w.ne(p).post();
		p.ne(x).post();
		p.ne(w).post();
		x.add(w).add(p).eq(12).post();

		y.ne(b).post();
		y.ne(q).post();
		b.ne(y).post();
		b.ne(q).post();
		q.ne(y).post();
		q.ne(b).post();
		y.add(b).add(q).eq(14).post();

		z.ne(v).post();
		z.ne(r).post();
		v.ne(z).post();
		v.ne(r).post();
		r.ne(z).post();
		r.ne(v).post();
		z.add(v).add(r).eq(19).post();

		x.ne(b).post();
		x.ne(r).post();
		b.ne(x).post();
		b.ne(r).post();
		r.ne(x).post();
		r.ne(b).post();
		x.add(b).add(r).eq(18).post();


		while(modelo.getSolver().solve())
		{

			System.out.println(x+" "+y+" "+z+"    "+15);
			matrizSolucion[0][0]=x.getValue();
			matrizSolucion[0][1]=y.getValue();
			matrizSolucion[0][2]=z.getValue();
			
			System.out.println(w+" "+b+" "+v+"    "+12);
			matrizSolucion[1][0]=w.getValue();
			matrizSolucion[1][1]=b.getValue();
			matrizSolucion[1][2]=v.getValue();

			System.out.println(p+" "+q+" "+r+"    "+18);
			matrizSolucion[2][0]=p.getValue();
			matrizSolucion[2][1]=q.getValue();
			matrizSolucion[2][2]=r.getValue();
			System.out.println("   "+12+"  "+14+"   "+19+"    "+18);


			//
			//			if(((x.getValue()==7) && ((x.getValue()+y.getValue()+z.getValue())==15))) {
			//				x.add(y).add(z).lt(15).post();
			//				System.out.println(x+" "+ y+" "+z);
			//			}
			//			if(((x.getValue()+y.getValue()+z.getValue())==12)) {
			//				x.add(y).add(z).lt(15).post();
			//				System.out.println("segundo"+" "+x+" "+ y+" "+z);
			//			}
			//			if(((x.getValue()==7) && ((x.getValue()+y.getValue()+z.getValue())==15)) && ((x.getValue())!=(y.getValue())&&(x.getValue())!=(z.getValue()))
			//					&& ((y.getValue())!=(x.getValue())&&(y.getValue())!=(z.getValue())) && ((z.getValue())!=(x.getValue())&&(z.getValue())!=(y.getValue())) ){
			//				System.out.println(x+" "+y+" "+z);
			//				x.add(y).add(z).lt(15).post();
			//			}
			//			if(((w.getValue()+b.getValue()+v.getValue())==12) && ((w.getValue())!=(b.getValue())&&(w.getValue())!=(v.getValue()))
			//					&& ((b.getValue())!=(w.getValue())&&(b.getValue())!=(v.getValue())) && ((v.getValue())!=(w.getValue())&&(v.getValue())!=(b.getValue())) ) {
			//				System.out.println(w+" "+b+" "+v);
			//				w.add(b).add(v).lt(12).post();
			//
			//			}
			//			if(((p.getValue()+q.getValue()+r.getValue())==18) && ((p.getValue())!=(q.getValue())&&(p.getValue())!=(r.getValue()))
			//					&& ((q.getValue())!=(p.getValue())&&(q.getValue())!=(r.getValue())) && ((r.getValue())!=(p.getValue())&&(r.getValue())!=(q.getValue()))) {
			//				p.add(q).add(r).lt(20).post();
			//				System.out.println(p+" "+q+" "+r);
			//			}
			//
			//			if(((x.getValue()+w.getValue()+p.getValue())==12) && ((x.getValue())!=(w.getValue())&&(x.getValue())!=(p.getValue()))
			//					&& ((w.getValue())!=(x.getValue())&&(w.getValue())!=(p.getValue())) && ((p.getValue())!=(x.getValue())&&(p.getValue())!=(w.getValue()))){
			//				System.out.println(x+" "+w+" "+p);
			//				x.add(w).add(p).lt(12).post();
			//			}
			//			if(((y.getValue()+b.getValue()+q.getValue())==14) && ((y.getValue())!=(b.getValue())&&(y.getValue())!=(q.getValue()))
			//					&& ((b.getValue())!=(y.getValue())&&(b.getValue())!=(q.getValue())) && ((q.getValue())!=(y.getValue())&&(q.getValue())!=(b.getValue()))) {
			//				y.add(b).add(q).lt(14).post();
			//				System.out.println(y+" "+b+" "+q);
			//			}
			//			if(((z.getValue()+v.getValue()+r.getValue())==14) && ((z.getValue())!=(v.getValue())&&(z.getValue())!=(r.getValue())) 
			//					&& ((v.getValue())!=(z.getValue())&&(v.getValue())!=(r.getValue())) && ((r.getValue())!=(z.getValue())&&(r.getValue())!=(v.getValue()))) {
			//				z.add(v).add(r).lt(14).post();
			//				System.out.println(z+" "+v+" "+r);
			//			}
			//
		}
	}

	/**
	 * Metodo que devuelve las posibles soluciones
	 * @return primeraFila
	 */
	public int[][] returnPrimerafila(){
		
		return matrizSolucion;
		
	}

	
}
