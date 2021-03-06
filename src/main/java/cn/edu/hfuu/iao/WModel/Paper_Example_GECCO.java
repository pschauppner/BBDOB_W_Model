package cn.edu.hfuu.iao.WModel;

/** Here we reproduce the example given in our paper. */
public class Paper_Example_GECCO {

  /**
   * The main routine
   *
   * @param args
   *          the args (ignored)
   */
  public static final void main(final String[] args) {
    final boolean[] x = { false, true, false, true, false, true, true,
        false, false, false, false, false, true, true, true, false, true,
        false, false, false, false, };

    System.out.print("Start: "); //$NON-NLS-1$
    Paper_Example_GECCO.__print(x);
    System.out.println();

    final boolean[] x_after_neutrality = new boolean[10];
    WModel_Boolean.neutrality(x, 2, x_after_neutrality);
    System.out.print("Neutrality: "); //$NON-NLS-1$
    Paper_Example_GECCO.__print(x_after_neutrality);
    System.out.println();

    final boolean[] x_after_epistasis = new boolean[x_after_neutrality.length];
    WModel_Boolean.epistasis(x_after_neutrality, 4, x_after_epistasis);
    System.out.print("Epistasis: "); //$NON-NLS-1$
    Paper_Example_GECCO.__print(x_after_epistasis);
    System.out.println();

    final boolean[][] x_after_multi_obj = new boolean[2][6];
    WModel_Boolean.multi_objectivity(x_after_epistasis, x_after_multi_obj);
    System.out.print("Multi-Objectivity: "); //$NON-NLS-1$
    Paper_Example_GECCO.__print(x_after_multi_obj[0]);
    System.out.print(" / "); //$NON-NLS-1$
    Paper_Example_GECCO.__print(x_after_multi_obj[1]);
    System.out.println();

    System.out.print("Objective: "); //$NON-NLS-1$
    final int f1 = WModel_Boolean.f(x_after_multi_obj[0],
        x_after_multi_obj[0].length);
    final int f2 = WModel_Boolean.f(x_after_multi_obj[1],
        x_after_multi_obj[0].length);
    System.out.print(f1);
    System.out.print(" / "); //$NON-NLS-1$
    System.out.println(f2);

    final int gamma = 12;
    final int gammaPrime = WModel_Ruggedness.ruggedness_translate(gamma,
        x_after_multi_obj[0].length);
    System.out.print("Gamma: "); //$NON-NLS-1$
    System.out.print(gamma);
    System.out.print(" / Gamma': "); //$NON-NLS-1$
    System.out.println(gammaPrime);

    final int[] ruggedness = WModel_Ruggedness.ruggedness(gamma,
        x_after_multi_obj[0].length);
    System.out.print("Ruggedness: "); //$NON-NLS-1$
    System.out.print(ruggedness[f1]);
    System.out.print(" / "); //$NON-NLS-1$
    System.out.println(ruggedness[f2]);
  }

  /**
   * print the boolean vector
   *
   * @param x
   *          the parameter
   */
  private static final void __print(final boolean[] x) {
    int i = 0;
    for (final boolean b : x) {
      System.out.print(b ? '1' : '0');
      if (((++i) % 4) == 0) {
        System.out.print(' ');
      }
    }
  }
}
