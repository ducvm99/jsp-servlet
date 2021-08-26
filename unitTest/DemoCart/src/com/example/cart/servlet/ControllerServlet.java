package com.example.cart.servlet;

import com.example.cart.controller.Cart;
import com.example.cart.model.Product;
import com.example.cart.model.ProductCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/Controller"})
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String action = request.getParameter("action");
            // tao moi gio hang
            switch (action) {
                case "Add to cart": {
                    // lay ve session
                    HttpSession session = request.getSession();
                    // khai bao 1 gio hang
                    Cart shop = (Cart) session.getAttribute("shop");
                    if (shop == null) {
                        shop = new Cart();
                    }
                    String code = request.getParameter("txtCode");
                    String name = request.getParameter("txtName");
                    String pri = request.getParameter("txtPrice");
                    double price = Double.parseDouble(pri);

                    Product s = new Product(code, name, price);

                    ProductCart sp = new ProductCart(s);
                    shop.addProduct(sp);

                    session.setAttribute("shop", shop);

                    // forward
                    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                // Xem gio hang
                case "View cart": {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                case "Add more": {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                case "Remove": {
                    String[] list = request.getParameterValues("remove");
                    if (list != null) {
                        HttpSession session = request.getSession();
                        if (session != null) {
                            Cart shop = (Cart) session.getAttribute("shop");
                            if (shop != null) {
                                for (String code : list) {
                                    shop.remove(code);
                                }
                                session.setAttribute("shop", shop);
                            }
                        }
                    }
                    String url = "Controller?action=View cart";
                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
