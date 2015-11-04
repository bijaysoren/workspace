package first;


import java.util.Random;
class BSTnode  {
	BSTnode left,right;
	int data; 

	public BSTnode(){
		data=0;
		left=null;
		right=null;
	}

	public BSTnode(int n){
		left=null;
		right=null;
		data=n;
	}

	public void setleft(BSTnode l){
		left=l;
	}

	public void setright(BSTnode r ){
		right=r;

	}

	public BSTnode getleft(){
		return left;

	}

	public BSTnode getright(){
		return right;
	}

	public void setdata(int n){
		data = n;
	}

	public int getdata(){
		return data;
	}

}


class BST {
	BSTnode root;

	public BST(){
		root=null;
	}

	public boolean isempty(){
		return root== null;
	}

	public void insert(int k){
		root=insert(root,k);
	}

	private BSTnode insert(BSTnode node,int data){

		if(node==null){
			node= new BSTnode( data);
		}
		else
		{
			if(data < node.getdata() ){
				node.left=insert(node.left,data);
			}
			else{
				node.right=insert(node.right,data);
			}
		}
		return node;

	}



	public void delete(int k)
	{
		if (isempty())
			System.out.println("Tree Empty");
		else if (search(k) == false)
			System.out.println("Sorry " + k + " is not present");
		else 
		{
			root = delete(root, k);
			System.out.println(k + " deleted from the tree");
		}
	}

	private BSTnode delete(BSTnode root,int k){

		BSTnode p,p2,n;
		if(root.getdata() ==k){
			BSTnode lt,rt;
			lt=root.left;
			rt=root.right;

			if(lt==null  && rt == null){
				return null;
			}else if(lt==null){
				p=rt;
				return p;
			}else if(rt==null){
				p=lt;
				return p;
			}else{
				p2=rt;
				p=rt;
				while(p.getleft() !=null){
					p=p.getleft();
				}
				p.setleft(lt);
				return p2;
			}

		}

		if( k < root.getdata()){
			n=delete(root.left,k);
			root.setleft(n);
		}

		else{
			n=delete(root.right,k);
			root.setright(n);
		}

		return root;


	}
	
	public boolean search(int val) 
    {
        return search(root, val);
    }
 
    /* Function to search for an element recursively */
    private boolean search(BSTnode r, int val) 
    {
        boolean found = false;
        while ((r != null) && !found) 
        {
            int rval = r.getdata();
            if (val < rval)
                r = r.getleft();
            else if (val > rval)
                r = r.getright();
            else 
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    
    public void inorder() 
    {
        inorder(root);
    }
 
    private void inorder(BSTnode r) 
    {
        if (r != null) 
        {
            inorder(r.getleft());
            System.out.print(r.getdata() + " ");
            inorder(r.getright());
        }
    }

}







public class binary_search_tree {
	
	 public static int N = 20;
	
	 public static void main(String args[]) 
	    {
	        Random random = new Random();
	        BST bt = new BST();
	 
	        System.out
	                .println("Sorting of randomly generated numbers using B TREE");
	 
	        for (int i = 0; i < N; i++)
	            bt.insert(Math.abs(random.nextInt(100)));
	 
	       
	 
	        System.out.println("\nThe sorted sequence is: ");
	        bt.inorder();
	    }



}
