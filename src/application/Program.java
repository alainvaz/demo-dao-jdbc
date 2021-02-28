package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department department = new Department(2, null);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		int x = 6;
		
		switch(x){
			case 1:
				System.out.println("=== Test 1: seller findById ====");
			
				Seller seller = sellerDao.findById(5);
			
				System.out.println(seller);
				break;
			case 2:
				System.out.println("\n=== Test 2: seller findByDepartment ====");
			
				List <Seller> sellers = sellerDao.findByDepartment(department);
			
				for(Seller obj : sellers) {
				
					System.out.println(obj);
				}
				break;
			case 3:
				System.out.println("\n=== Test 3: seller findByDepartment ====");		
			
				List <Seller> allSellers = sellerDao.findAll();
			
				for(Seller obj : allSellers) {
				
					System.out.println(obj);
				}
				break;
			case 4:
				System.out.println("\n=== Test 4: seller insert ====");
			
			Seller newSeller = new Seller(null, "Jorge", "jorge@gmail.com",new Date(), 2500.0, department);
			
			sellerDao.insert(newSeller);
			
			System.out.println("Inserted! New ID = " + newSeller.getId());
			
				break;
			case 5:
				System.out.println("\n=== Test 5: seller update ====");
			
				Seller updateSeller = sellerDao.findById(1);
			
				updateSeller.setName("Jujuba bruxinha");
			
				sellerDao.update(updateSeller);
			
				System.out.println("Update Completed!");
				break;
				
			case 6:
				System.out.println("\n=== Test 6: seller delete ====");
				sellerDao.deleteById(10);
				System.out.println("Delete completed");
		}
		
	}

}
