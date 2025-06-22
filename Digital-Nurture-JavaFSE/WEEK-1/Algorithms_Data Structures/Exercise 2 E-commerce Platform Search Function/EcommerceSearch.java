import java.util.*;

public class EcommerceSearch {
    static class Product {
        int productId;
        String productName, category;
        public Product(int productId,String productName,String category){
            this.productId=productId;
            this.productName=productName;
            this.category=category;
        }
        public String toString(){
            return productId+" - "+productName+" ("+category+")";
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Product[] products={
            new Product(101,"Phone","Electronics"),
            new Product(102,"Laptop","Electronics"),
            new Product(103,"Shoes","Footware"),
            new Product(104,"Watch","Fashion"),
            new Product(105,"Headphones","Electronics")
        };
        Arrays.sort(products,Comparator.comparingInt(p->p.productId));
      
        int searchId=sc.nextInt();
        Product result1=linearSearch(products,searchId);
        System.out.println("Linear Search Result: "+(result1!=null?result1:"Not Found"));
        Product result2=binarySearch(products,searchId);
        System.out.println("Binary Search Result: "+(result2!=null?result2:"Not Found"));
    }

    public static Product linearSearch(Product[] arr,int id){
        for(Product p:arr){
            if(p.productId==id)return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] arr,int id){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid].productId==id)return arr[mid];
            else if(arr[mid].productId<id)low=mid+1;
            else high=mid-1;
        }
        return null;
    }
}
