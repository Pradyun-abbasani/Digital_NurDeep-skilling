public class DependencyInjectionExample {
    interface CustomerRepository {
        String findCustomerById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        public String findCustomerById(int id) {
            return "Customer" +" "+ id + " Found";
        }
    }

    static class CustomerService {
        private CustomerRepository repo;
        public CustomerService(CustomerRepository repo) {
            this.repo = repo;
        }
        public void getCustomer(int id) {
            System.out.println(repo.findCustomerById(id));
        }
    }

    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.getCustomer(1000);
    }
}
