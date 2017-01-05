
package model;
/*
 * BinaryTree.java
 */

/**
 * Classe générique pour la représentation et la manipulation d'un arbre binaire.
 * Implémentation purement dynamique adaptée aux traitements récursifs des arbres.
 * @param <E>
 * @author Erick Timmerman <Erick.Timmerman@univ-lille1.fr>
 */
public class Tree<E>
{
    // classe utilitaire interne pour la représentation d'un triplet:
    //  (valeur, arbre binaire, arbre binaire)
    private class Node<T>
    {

        private T value;                    // valeur de la racine (de type générique T)
        private BinaryTree<T> left;         // sous-arbre gauche, un arbre binaire
        private BinaryTree<T> right;        // sous-arbre droit, un arbre binaire

        /* 
         *  Création d'un noeud comportant une valeur fournie et 2 arbres vides. 
         */
        private Node(T value)               // création d'un noeud simple (une feuille)
        {
            this.value = value;
            // Création des sous-arbres "gauche" et "droit" vides
            this.left  = new BinaryTree<>();
            this.right = new BinaryTree<>();
        }
        
        /* 
         *  Création d'un noeud comportant une valeur et 2 arbres fournis. 
         */
        private Node(T value, BinaryTree<T> left, BinaryTree<T> right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }    // Fin de la classe interne "Node"

    private Node<E> root;              // seul attribut de la classe "BinaryTree""

    // Constructeurs

    /**
     * Création d'un arbre vide.
     */
    public BinaryTree()
    {
        this.root = null;    // pas de noeud, affectation inutile = valeur par défaut.
    }

    /**
     * Création d'un arbre "feuille" (arbre réduit à un seul "noeud").
     * @param valeur
     */
    public BinaryTree(E valeur) 
    {
        this.root = new Node<>(valeur);     // un noeud "simple"
    }

    /**
     * Création d'un arbre binaire dont on connait la valeur à placer à la
     * racine ainsi que les 2 sous-arbres.
     * @param valeur
     * @param gauche
     * @param droit
     */

    public BinaryTree(E valeur, BinaryTree<E> gauche, BinaryTree<E> droit)
    {
        this.root = new Node<>(valeur, gauche, droit);
    }

    // Méthodes utilitaires basiques.

    /**
     * détermine si l'arbre (this) est vide ou non.
     * @return true ssi l'arbre est vide.
     */
    public boolean estVide()
    {
        return this.root == null;
    }

    /**
     * Fournit la "racine" de l'arbre, l'arbre ne doit pas être vide.
     * @return la valeur à la racine de l'arbre.
     */
    public E racine()
    {
        return this.root.value;
    }

    /**
     * Fournit le sous arbre gauche de l'arbre, l'arbre (this) ne doit pas être vide.
     * @return le sous arbre gauche de l'arbre.
     */
    public BinaryTree<E> gauche()
    {
        return this.root.left;
    }

    /**
     * Fournit le sous arbre droit de l'arbre, l'arbre (this) ne doit pas être vide.
     * @return le sous arbre droit de l'arbre.
     */
    public BinaryTree<E> droit()
    {
        return this.root.right;
    }

    /*
     *   Modifie la valeur à la racine de l'arbre, l'arbre ne doit pas être vide.
     */
    private void setRacine(E val)
    {
        this.root.value = val;
    }

    /*
     *   Modifie l'arbre de façon qu'il "devienne" celui fourni en argument.
     */
    private void setTree(BinaryTree<E> tree)
    {
        this.root = tree.root;
    }

// On peut dès à présent "oublier" la classe interne "Node".
   
    /**
     * @return la suite "préfixe" des valeurs de l'arbre.
     */
    public String prefixe()        // préfixe ou "RGD"
    {
        if (this.estVide())
            return "";
        return this.racine() + this.gauche().prefixe() + this.droit().prefixe();
        // appel implicite à "toString" de la classe "E" (pour la racine).
    }

    /**
     * @return la suite "infixe" des valeurs de l'arbre.
     */

    public String infixe()         // infixe ou "GRD"
    {
        if (this.estVide())
            return "";
        return this.gauche().infixe() + this.racine() + this.droit().infixe();
        // appel implicite à "toString" de la classe "E" (pour la racine).
    }

    /**
     * @return la suite "suffixe" des valeurs de l'arbre.
     */
    public String suffixe()        // suffixe ou "postfixe" ou "GDR"
    {
        if (this.estVide())
            return "";
        return this.gauche().suffixe() + this.droit().suffixe() + this.racine();
    }

    /**
     * Détermine si l'arbre est réduit à une feuille (un seul noeud).
     * L'arbre ne doit pas être vide.
     * @return true ssi l'arbre est une feuille.
     */
    public boolean estUneFeuille()
    {
        return this.gauche().estVide() && this.droit().estVide();
    }
    
    /**
     * Fournit l'expression de type "fonctionnelle" représentant l'arbre.
     * @return a string representation of the tree.
     */
    @Override
    public String toString() // retourne l'expression de type "fonctionnelle"
    {
        if (this.estVide())
            return "";
        if (this.estUneFeuille())
            return this.racine().toString();
        return this.racine() + "(" + this.gauche() + "," + this.droit() + ")";
        /* appels implicites à la méthode "toString" de la classe "E" (pour la racine)
         * et à celle de la classe "BinaryTree" (pour les sous-arbres). 
	 */
    }

    /**
     * Fournit le nombre de noeuds de l'arbre.
     * @return le nombre de noeuds de l'arbre.
     */
    public int nbNoeuds()
    {
    	return 1 + this.gauche().nbNoeuds() + this.droit().nbNoeuds();

    }

    /**
     * Détermine la "hauteur" (nombre de noeuds sur la branche la plus longue)
     * de l'arbre.
     * @return la hauteur de l'arbre.
     */
    public int hauteur()
    {
        if (this.estVide())
            return 0;
        
        return 1 + Math.max(this.gauche().hauteur(), this.droit().hauteur()); 
     /* ou:
        int hGauche = this.gauche().hauteur();
        int hDroit = this.droit().hauteur();

        if (hGauche > hDroit)
            return hGauche + 1;
        return hDroit + 1; 
      */
    }

    /**
     * Détermine si l'arbre est "binaire pur", ie: chaque noeud est soit une
     * feuille, soit aucun de ses sous arbres n'est vide.
     * @return true ssi l'arbre est binaire pur.
     */
    public boolean estBinairePur()
    {
        if (this.estVide() || this.estUneFeuille())
            return true;
        if (this.gauche().estVide() || this.droit().estVide())
            return false;

        return this.gauche().estBinairePur() && this.droit().estBinairePur();
    }

    public String prefixeIteratif()
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String infixeIteratif()
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String parNiveau()
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String suffixeIteratif()
    {
        // to do!
        throw new UnsupportedOperationException("Not supported yet.");
    }

   /**
     * Constructeur, construction à partir d'un "vecteur" (array) d'éléments.
     * 
     * Construction d'un arbre "parfaitement balancé" ayant pour valeurs
     * les éléments du vecteur; la racine est choisie comme étant le 1er élément.
     * 
     * Ceci permettra de réaliser des tests avec des arbres non "triviaux".
     * @param elts
     */
    public BinaryTree(E[] elts)
    {
        this();
        setTree(makePBTWith(elts, 0, elts.length - 1));
    }

    private BinaryTree<E> makePBTWith(E[] elts, int indexDebut, int indexFin)
    {
        if (indexDebut > indexFin)    // portion de vecteur vide
            return new BinaryTree<>();

        int nb = (indexFin + indexDebut + 1) / 2;

        // Construction des sous-arbres.
        BinaryTree<E> g = makePBTWith(elts, indexDebut + 1, nb);
        BinaryTree<E> d = makePBTWith(elts, nb + 1, indexFin);

        return new BinaryTree<>(elts[indexDebut], g, d);
    }    

}
