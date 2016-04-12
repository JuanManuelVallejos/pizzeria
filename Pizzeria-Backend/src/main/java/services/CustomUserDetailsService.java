package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Cliente;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import repositories.ClienteDAO;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService extends GenericService<Cliente> implements UserDetailsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4764677583367261801L;

	@Override
	public UserDetails loadUserByUsername(String numeroDeCliente) throws UsernameNotFoundException, DataAccessException {
		Cliente cliente = ((ClienteDAO) this.getRepository()).buscarPorNumeroDeCliente(numeroDeCliente);
		
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        User user;
        user = new User(cliente.getNumeroDeCliente().toString(),cliente.getPassword(),enabled,accountNonExpired,credentialsNonExpired,
        		accountNonLocked,getAuthorities(cliente.getRol().getId()));
        return user;

	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer rol) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(rol));
        return authList;
    }

	public List<String> getRoles(Integer rol) {
		 
        List<String> roles = new ArrayList<String>();
 
        if (rol.intValue() == 1) {
            roles.add("ROLE_USER");
        } else if (rol.intValue() == 2) {
        	roles.add("ROLE_ADMIN");
        }
        return roles;
    }
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for (String rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol));
        }
        return authorities;
    }
	
}
