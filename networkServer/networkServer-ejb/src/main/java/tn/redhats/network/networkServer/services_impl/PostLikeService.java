package tn.redhats.network.networkServer.services_impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.redhats.network.networkServer.entities.Post;
import tn.redhats.network.networkServer.entities.PostLike;
import tn.redhats.network.networkServer.entities.User;
import tn.redhats.network.networkServer.services.PostLikeServiceRemote;

@Stateless
@LocalBean
public class PostLikeService implements PostLikeServiceRemote {
	@PersistenceContext(unitName = "networkServer-ejb")
	EntityManager em;

	@Override
	public int AddPostLike(PostLike pstlike) {
		em.persist(pstlike);
		return pstlike.getId();
	}
	@Override
	public void RemovePost(int id) {
		System.out.println("in remove ****************************************************************");
		em.remove(em.find(PostLike.class, id));
	}

	@Override
	public List<PostLike> findAllPostLike() {
		List<PostLike> postLike = em.createQuery("select p from PostLike p", PostLike.class).getResultList();
		return postLike;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> findPostLikeByOwner(User u) {

		List<Post> p = em.createQuery("select p from PostLike p where p.likedBy =:" + u.getId()).getResultList();
		return p;
	}

	@Override
	public PostLike findLikeById(int id) {
		return em.find(PostLike.class, id);
	}

	public PostLike findlike(Post idpost, User id) {
		try {
			Query query = em.createQuery("select c from PostLike c where c.likedBy =:id and c.post =:idpost",
					PostLike.class);
			query.setParameter("id", id);
			query.setParameter("idpost", idpost);
			PostLike p = (PostLike) query.getSingleResult();
			return p ;
		} catch (NoResultException nre) {
			return new PostLike();
		}
	}

}
