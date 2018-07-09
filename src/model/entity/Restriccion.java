package model.entity;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;

public final class Restriccion {
	public static boolean restringe(PersistenceManager pm,com.google.appengine.api.users.User usuarioGoogle,String url,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
	if(usuarioGoogle==null){
		response.sendRedirect("/UsersControllerLogin");
	}
	else{
		
		
		if(usuarioGoogle.getEmail().equals("edavila@unsa.edu.pe")){
			return true;
		}else{
			String queryUsuario="select from "+User.class.getName()+" where correo=='"+ usuarioGoogle.getEmail() + "'"+
					" && status==true";
			@SuppressWarnings("unchecked")
			List<User> buscarUsuario=(List<User>) pm.newQuery(queryUsuario).execute();
			
			if(buscarUsuario.isEmpty()){
				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/views/Denegados/denied.jsp");
				dispatcher.forward(request, response);
			}
			else{
				String queryRecursos="select from "+Resource.class.getName()+" where Nombre=='" + request.getServletPath() + "'"+
						" && status==true";
				List<Resource> buscarRecurso=(List<Resource>) pm.newQuery(queryRecursos).execute();
			
				if(buscarRecurso.isEmpty()){
					RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/views/Denegados/denied.jsp");
					dispatcher.forward(request, response);
				}
				else{
					String queryAccess="select from "+Access.class.getName()+
						" where role==" + buscarUsuario.get(0).getRole()+
						" && resource=="+ buscarRecurso.get(0).getID()+
						" && status==true";
					List<Access> buscarAcceso=(List<Access>) pm.newQuery(queryAccess).execute();
					if(buscarAcceso.isEmpty()){
						RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/views/Denegados/denied.jsp");
						dispatcher.forward(request, response);
					}
					else{
						return true;
					}
				}
		
			}
			
		}
		
		
		
	}
	return false;
	}
	
}
