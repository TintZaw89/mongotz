import React, {useState, useEffect} from 'react'
import {Link, useNavigate, useParams } from 'react-router-dom';
import MovieService from './MovieService';
const ConfigMovieComponent = () => {

    const [summaryText, setSummaryText] = useState('')
    const history = useNavigate();
    const {id} = useParams();

    const saveOrUpdateMovie = (e) => {
        e.preventDefault();

        const movie = {summaryText}

        if(id){
            MovieService.updateMovie(id, movie).then((response) => {
                history.push('/imdbmovie');
            }).catch(error => {
                console.log(error)
            })

        }else{
            MovieService.createMovie(movie).then((response) =>{

                console.log(response.data)
    
                history.push('/imdbmovie');
    
            }).catch(error => {
                console.log(error)
            })
        }
        
    }

    useEffect(() => {

        MovieService.getMovieById(id).then((response) =>{
            setSummaryText(response.data.summaryText)
        }).catch(error => {
            console.log(error)
        })
    }, [id])

    const title = () => {

        if(id){
            return <h2 className = "text-center">Update Movie</h2>
        }else{
            return <h2 className = "text-center">Add Movie</h2>
        }
    }

    return (
        <div>
           <br /><br />
           <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                       {
                           title()
                       }
                        <div className = "card-body">
                            <form>
                                <div className = "form-group mb-2">
                                    <label className = "form-label"> Summary :</label>
                                    <textarea rows="4" cols="50"
                                        placeholder = "Edit Summary"
                                        name = "summary"
                                        className = "form-control"
                                        value = {summaryText}
                                        onChange = {(e) => setSummaryText(e.target.value)}
                                    >
                                    </textarea>
                                </div>

                                <div>
                                <button className = "btn btn-success" onClick = {(e) => saveOrUpdateMovie(e)} >Submit </button>
                                <Link to="/imdbmovie" className="btn btn-danger"> Cancel </Link>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}

export default ConfigMovieComponent
