import React from "react";
import { Link } from 'react-router-dom'

const MovieTable = props =>
{
    const { movies } = props;
    return (
        <div className= "container">
        <table className="table table-striped" >
                    <thead>
                        <tr>
                            <td>Imdb ID</td>
                            <td>Movie Name</td>
                            <td>Released Year</td>
                            <td>Run Time</td>
                            <td>Genre</td>
                            <td>Total Rating</td>
                            <td>Rating</td>
                            <td>Director</td>
                            <td>Cast</td>
                            <td>Summary</td>
                            <td>Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            movies?.map(
                                movie =>
                                    <tr key={movie._id}>
                                        <td>{movie.imdbId}</td>
                                        <td>{movie.name}</td>
                                        <td>{movie.year}</td>
                                        <td>{movie.runTime}</td>
                                        <td>{movie.genre?.map(genre => <div key={genre}>{genre}</div>)}</td>
                                        <td>{movie.ratingCount}</td>
                                        <td>{movie.ratingValue}</td>
                                        <td>{movie.director}</td>
                                        <td>{movie.cast?.map(cast => <div key={cast.name}>{cast.name}</div>)}</td>
                                        <td>{movie.summaryText}</td>
                                        <td><Link className="btn btn-info" to={`/edit-imdbmovie/${movie.imdbId}`} >Update Summary</Link></td>
                                    </tr>
                            )
                        }
                    </tbody>
        </table>
        </div>
    )
}

export default MovieTable;