import axios from 'axios'
const host = process.env.REACT_APP_HOST;
const IMDB_MOVIE_BASE_REST_API_URL = `http://${host}:8100/api/imdbMovie`;
class MovieService{

    createMovie(movie){
        return axios.post(IMDB_MOVIE_BASE_REST_API_URL + '/addMovie', movie)
    }

    getMovieById(movieId){
        return axios.get(IMDB_MOVIE_BASE_REST_API_URL + '/getMovie/' + movieId);
    }

    updateMovie(movieId, movie){
        return axios.put(IMDB_MOVIE_BASE_REST_API_URL + '/updateMovie/' + movieId, movie);
    }

    deleteMovie(movieId){
        return axios.delete(IMDB_MOVIE_BASE_REST_API_URL + '/' + movieId);
    }
}

// eslint-disable-next-line import/no-anonymous-default-export
export default new MovieService(); //new